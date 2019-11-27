import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Location from '../views/Location.vue'
import Hospital from '../views/Hospital.vue'
import CreateHospital from '../views/CreateHospital.vue'
import Login from '../views/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/location',
    name: 'location',
    component: Location
  },
  {
    path: '/hospital/create',
    name: 'CreateHospital',
    component: CreateHospital
  },
  {
    path: '/hospital/:id',
    name: 'Hospital',
    component: Hospital
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
