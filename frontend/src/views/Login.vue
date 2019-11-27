<template>
  <div class="container">
    <form>
      <div class="form-group">
        <label for="exampleInputEmail1">Username</label>
        <input
          type="text"
          class="form-control"
          id="exampleInputEmail1"
          aria-describedby="emailHelp"
        />
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Password</label>
        <input
          type="password"
          class="form-control"
          id="exampleInputPassword1"
        />
      </div>
    </form>
    <button @click="login" type="submit" class="btn btn-primary">Submit</button>
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
      console.log(auth);
    },
  },
};
</script>
