// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import BootstrapVue from "bootstrap-vue"
import App from './App'
import router from './router'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import AOS from 'aos'
import 'aos/dist/aos.css'
import VueCookie from'vue-cookie'
import firebase from 'firebase'
import Vuetify from 'vuetify'


Vue.use(BootstrapVue)
Vue.use(VueCookie)
Vue.use(firebase)
Vue.use(Vuetify)
Vue.config.productionTip = false

Vue.use(VueCookie);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
  created () {
    AOS.init()
  },
  render: h => h(App)
})
