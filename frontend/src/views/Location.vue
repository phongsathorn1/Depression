<template>
  <div style="height: 100vh;">
    <div style="height: 90%;" class="container">
      <h2>โรงพยาบาลในระแวกใกล้เคียง</h2>
      <div class="form-group">
        <label for="formControlRange">ระยะ {{ range }}</label>
        <input
          min="1"
          @change="getFilterLocation"
          v-model="range"
          type="range"
          class="form-control-range"
          id="formControlRange"
        />
      </div>
      <div id="map"></div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      range: 2,
      filteredHospital: {},
    };
  },
  mounted() {
    // eslint-disable-next-line no-undef
    this.map = new google.maps.Map(document.getElementById("map"), {
      center: { lat: -34.397, lng: 150.644 },
      zoom: 8,
    });
    this.$nextTick(() => {
      this.getUserLocation();
    });
  },
  methods: {
    getUserLocation() {
      if (navigator.geolocation) {
        // get user location and then animate map to the position
        navigator.geolocation.getCurrentPosition(
          async position => {
            console.log(position);
            this.position = position.coords;
            this.map.panTo({
              lat: this.position.latitude,
              lng: this.position.longitude,
            });
            this.map.setZoom(20);
            // eslint-disable-next-line no-undef
            this.userMarker = new google.maps.Marker({
              position: {
                lat: this.position.latitude,
                lng: this.position.longitude,
              },
              map: this.map,
              title: "myMarker",
            });
            await this.generateMarker(this.range);
          },
          async () => {
            // error handling
            alert(
              "USER LOCATION CANNOT PERFORM ON HTTP: AUTOMATICAL SET LOCATION TO KMITL"
            );
            this.position = {
              latitude: 13.73103,
              longitude: 100.7790245,
            };
            this.map.panTo({
              lat: this.position.latitude,
              lng: this.position.longitude,
            });
            this.newLocation = {
              longitude: this.position.latitude,
              latitude: this.position.longitude,
            };
            this.map.setZoom(15);
            // eslint-disable-next-line no-undef
            this.userMarker = new google.maps.Marker({
              position: {
                lat: this.position.latitude,
                lng: this.position.longitude,
              },
              map: this.map,
              title: "myMarker",
            });
            await this.generateMarker(this.range);
          },
          { timeout: 10000 }
        );
      } else {
        alert("this browser does not support geolocation");
      }
    },
    async generateMarker(range) {
      console.log("let gen marker");
      let { data } = await axios.get(
        "http://35.225.198.249:8000/location/filter?" +
          `lat=${this.position.latitude}&lon=${this.position.longitude}&km=${range}`
      );
      let newData = {};
      data.forEach(el => {
        newData[el.id] = el;
      });
      let diff = this.arr_diff(
        Object.keys(newData),
        Object.keys(this.filteredHospital)
      );
      diff.forEach(id => {
        if (
          diff.includes(id) &&
          !Object.keys(this.filteredHospital).includes(id)
        ) {
          this.filteredHospital[id] = {};
          this.filteredHospital[id].data = newData[id];
          // eslint-disable-next-line no-undef
          this.filteredHospital[id].marker = new google.maps.Marker({
            position: {
              lat: newData[id].latitude,
              lng: newData[id].longitude,
            },
            icon: require('../assets/hospital.png'),
            map: this.map,
            title: newData[id].name,
            // eslint-disable-next-line no-undef
            animation: google.maps.Animation.DROP,
          });
          // eslint-disable-next-line no-undef
          google.maps.event.addListener(
            this.filteredHospital[id].marker,
            "click",
            () => {
              window.location.href = "/hospital/" + id;
            }
          );
        } else if (
          diff.includes(id) &&
          Object.keys(this.filteredHospital).includes(id)
        ) {
          console.log("delete");
          this.filteredHospital[id].marker.setMap(null);
          delete this.filteredHospital[id];
        }
      });
    },
    arr_diff(a1, a2) {
      var a = [],
        diff = [];

      for (var i = 0; i < a1.length; i++) {
        a[a1[i]] = true;
      }

      // eslint-disable-next-line no-redeclare
      for (var i = 0; i < a2.length; i++) {
        if (a[a2[i]]) {
          delete a[a2[i]];
        } else {
          a[a2[i]] = true;
        }
      }

      for (var k in a) {
        diff.push(k);
      }

      return diff;
    },
    getFilterLocation() {
      this.generateMarker(this.range);
    },
  },
};
</script>

<style>
#map {
  height: 100%;
}
</style>
