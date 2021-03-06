import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'https://' + config.build.host + ':'
var backendUrl = 'https://' + config.build.backendHost + ':'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
  name: 'login',
  data() {
    return {
      username: '',
      password: '',
      errorLogin: '',
      response: '',
    }
  },
  methods: {
    login(username, password) {
      if (username === '') {
        var errorMsg = "Invalid username"
        console.log(errorMsg)
        this.errorLogin = errorMsg
        return
      }
      if (password === '') {
        var errorMsg = "Invalid password"
        console.log(errorMsg)
        this.errorLogin = errorMsg
        return
      }
      console.log(`/?Email=`+username+'&Password='+password)
      AXIOS.get(`/login?Email=`+username+'&Password='+password)
        .then(response => {
          this.response = response.data
          this.errorLogin = ''

          this.$cookie.set('username', username, { expires: '1h' })
          this.$cookie.set('password', password, { expires: '1h' })

          this.username = this.$cookie.get("username") || ''
          this.password = this.$cookie.get("password") || ''

          this.$cookie.set('id', this.response['coopUserId'])
          this.$cookie.set('name', this.response['name'])

          window.location.href = '/#/home/';
        })
        .catch(e => {
          var errorMsg = "Invalid email or password!"
          console.log(errorMsg)
          this.errorLogin = errorMsg
        });
    }
  }
}
