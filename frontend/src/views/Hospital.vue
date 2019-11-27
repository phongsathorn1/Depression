<template>
  <div class="container">
    <h2>{{ name }}</h2>
    <p>{{ description }}</p>
    <div id="map"></div>
  </div>
</template>

<script>
import axios from "axios";
/* eslint-disable no-undef */
export default {
  data() {
    return {
      name: "",
      description: "",
    };
  },
  async mounted() {
    this.map = new google.maps.Map(document.getElementById("map"), {
      center: { lat: -34.397, lng: 150.644 },
      zoom: 8,
      streetViewControl: false,
      disableDefaultUI: true,
    });
    let icon = require("../assets/hospital.png");
    let { data } = await axios.get(
      "http://35.225.198.249:8000/location/" + this.$route.params.id
    );
    this.name = data.name;
    this.description = data.description;
    this.map.panTo({
      lat: data.latitude,
      lng: data.longitude,
    });
    this.map.setZoom(15);
    this.hospital = new google.maps.Marker({
      position: {
        lat: data.latitude,
        lng: data.longitude,
      },
      icon: icon,
      map: this.map,
      title: "{{ name }}",
      animation: google.maps.Animation.DROP,
    });
  },
};
</script>

<style scoped>
#map {
  height: 50vh;
  border-radius: 10px;
}
</style>
