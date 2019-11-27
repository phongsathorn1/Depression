<template>
  <div>
    <button @click="login" type="button" class="btn btn-primary">login</button>
  </div>
</template>

<script>
const axios = require("axios");
const oauth = require("axios-oauth-client");

export default {
  methods: {
    async login() {
      const getOwnerCredentials = oauth.client(axios.create(), {
        url: "http://35.236.184.82:8888/oauth/token",
        grant_type: "password",
        client_id: "fooClientId",
        client_secret: "secret",
        username: "doctoryora",
        password: "password",
        scope: "read write",
      });
      const auth = await getOwnerCredentials();
      console.log(auth)
    },
  },
};
</script>
