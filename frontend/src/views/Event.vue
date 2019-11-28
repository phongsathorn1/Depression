<template>
  <div class="container p-3">
    <div v-for="e in events" :key="e.event_id" class="card m-3">
      <div class="card-header">
        <h3>{{ e.event_name }}</h3>
      </div>
      <div class="card-body">
        <p>{{ e.event_date }}</p>
        <p>{{ e.event_place }}</p>

        <b-button variant="warning" @click.prevent="delEvent(e.event_id)">ลบ Event</b-button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "event",
  data() {
    return {
      events: []
    };
  },
  mounted() {
    let self = this;

    this.axios.get("http://35.247.175.250:8000/view").then(response => {
      console.log(response.data);
      self.events = response.data;
    });
  },
  methods: {
    delEvent(id) {
      this.axios
        .delete("http://35.247.175.250:8000/delete/" + id)
        .then(response => {
          console.log(response.data);
          self.events = response.data;
        })
        .then(() => {
          window.location.reload();
        });
    }
  }
};
</script>