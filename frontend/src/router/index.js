import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Location from '../views/Location.vue'
import Hospital from '../views/Hospital.vue'
import CreateHospital from '../views/CreateHospital.vue'
import Login from '../views/Login.vue'
import Event from '../views/Event.vue'
import ManageEvent from '../views/ManageEvent.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/hospital',
    name: 'hospital',
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
  },
  {
    path: '/event',
    name: 'Event',
    component: Event
  },
  {
    path: '/manageEvent',
    name: 'ManageEvent',
    component: ManageEvent
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
