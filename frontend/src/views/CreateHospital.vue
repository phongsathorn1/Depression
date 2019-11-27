<template>
  <div>
    <div class="container">
      <h2>เพิ่มโรงพยาบาล</h2>
      <form>
        <div class="form-group">
          <label>ชื่อ</label>
          <input
            v-model="name"
            type="text"
            class="form-control"
            placeholder="โรงพยาบาลหัวเฉียว"
          />
        </div>
        <div class="form-group">
          <label>รายละเอียด</label>
          <textarea
            v-model="description"
            class="form-control"
            placeholder="ที่อยู่ ประวัติโดยคร่าว"
            rows="3"
          ></textarea>
        </div>
      </form>
      <label>คลิกเลือกสถานที่</label>
      <div id="map"></div>
      <span>{{ load }}</span>
      <div style="margin-bottom: 10px;">
        <button @click="submit" type="button" class="btn btn-success">
          ส่ง
        </button>
        <button type="button" class="btn btn-danger">ยกเลิก</button>
      </div>
    </div>
  </div>
</template>

<script>
/* eslint-disable no-undef */
import axios from "axios";

export default {
  data() {
    return {
      name: "",
      description: "",
      phone: "",
      facebook: "",
      load: "",
    };
  },
  mounted() {
    this.map = new google.maps.Map(document.getElementById("map"), {
      center: { lat: -34.397, lng: 150.644 },
      zoom: 8,
      streetViewControl: false,
      disableDefaultUI: true,
    });
    google.maps.event.addListener(this.map, "click", event => {
      this.placeMarker(event.latLng);
    });
    this.$nextTick(() => {
      this.getUserLocation();
    });
  },
  methods: {
    getUserLocation() {
      let icon = require("../assets/hospital.png");
      if (navigator.geolocation) {
        // get user location and then animate map to the position
        navigator.geolocation.getCurrentPosition(
          position => {
            this.position = position.coords;
            this.map.panTo({
              lat: this.position.latitude,
              lng: this.position.longitude,
            });
            this.newLocation = {
              longitude: this.position.latitude,
              latitude: this.position.longitude,
            };
            this.map.setZoom(15);
            this.userMarker = new google.maps.Marker({
              position: {
                lat: this.position.latitude,
                lng: this.position.longitude,
              },
              icon: icon,
              map: this.map,
              title: "myMarker",
            });
          },
          () => {
            // error handling
            alert("Geolocation are not currently available");
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
            this.userMarker = new google.maps.Marker({
              position: {
                lat: this.position.latitude,
                lng: this.position.longitude,
              },
              icon: icon,
              map: this.map,
              title: "myMarker",
            });
          },
          { timeout: 10000 }
        );
      } else {
        alert("this browser does not support geolocation");
      }
    },
    async submit() {
      this.load = "loading";
      try {
        await axios.post("http://35.225.198.249:8000/location/", {
          name: this.name,
          description: this.description,
          ...this.newLocation,
        });
        alert("add location successful");
      } catch (error) {
        alert("PERMISSION DENIED");
      }
    },
    placeMarker(location) {
      this.newLocation = {
        longitude: location.lng(),
        latitude: location.lat(),
      };
      this.userMarker.setPosition(
        new google.maps.LatLng(
          this.newLocation.latitude,
          this.newLocation.longitude
        )
      );
    },
  },
};
</script>

<style>
#map {
  height: 50vh;
  border-radius: 10px;
}
</style>
