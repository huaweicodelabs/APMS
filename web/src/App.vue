<template>
  <div id="app">
    <h1>{{ msg }}</h1>
    <div>SDK Status: {{ enable ? 'Enable' : 'Disable' }}</div>
    <div class="enable">
      <button @click="enableSdk(true)">enable</button>
      <button @click="enableSdk(false)">disable</button>
    </div>
    <div class="router">
      <button>
        <router-link to="/pageA">PageA</router-link>
      </button>
      <button>
        <router-link to="/pageB">PageB</router-link>
      </button>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      msg: 'Welcome to CodeLab',
      enable: true
    }
  },
  methods: {
    enableSdk (val) {
      const {APM} = window
      this.enable = val
      APM.enable(this.enable)
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.router {
  text-align: left;
  margin-bottom: 50px;
}
.router button {
  margin: 0 20px;
}
.enable button {
  margin: 10px;
}
</style>
