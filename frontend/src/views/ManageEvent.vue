<template>
  <div class="container p-3">
    <div v-if="msg">{{ msg }}</div>
    <h1>Manage Event</h1>

    <span>ชื่อ Event:</span>
    <b-form-input v-model="event.event_name" placeholder="Enter Event name"></b-form-input>

    <span>เวลาจัดงาน:</span>
    <b-form-input v-model="event.event_date" placeholder="Enter Event date"></b-form-input>

    <span>สถานที่:</span>
    <b-form-input v-model="event.event_place" placeholder="Enter place"></b-form-input>

    <b-button variant="primary" @click.prevent="addEvent()">เพิ่ม Event</b-button>
  </div>
</template>

<script>
export default {
  name: "manageEvent",
  data() {
    return {
      event: {
        event_name: null,
        event_date: null,
        event_place: null
      },
      msg: null
    };
  },
  methods: {
    addEvent() {
      let self = this;
      this.axios
        .post("http://35.247.175.250:8000/add", this.event)
        .then(response => {
          self.msg = response.body;
        })
        .catch(function(error) {
          self.msg = error;
        });
    }
  }
};
</script>