import axios from 'axios'
var config = require('../../config')


//var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
//var backendUrl='https://cooperator-backend-060606.herokuapp.com/'

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {
    data(){
      return {

        students: '',
        studentsName: [],
        coopTerms:[]
      }
  },

    created: function () {
      AXIOS.get(`coopTerm/employer/4`)
       .then(response => {
         this.coopTerms = response.data

      })
        .catch(e =>{
         console.log("error in get coopterm request: " + e);
         this.error = e;
        })
  },

  methods: {
    isActive: function (coopTerm) {

      if (coopTerm.state === "ACTIVE") {
        return "Active";
      } else {
        return "Not Active";
      }
    },

    studentName: function (id,index) {

      AXIOS.get(`student/` + id)
        .then(response =>{
          this.students = response.data;
          this.studentsName.push(this.students.name) ;
        })
        .catch(e => {
                    console.log("error in get student request:" + e);
                    this.error = e;
                  })

      return  this.studentsName[index];

      // .then(()=> {
      //     for (var i = 0; i < this.coopTerms.length; i++) {
      //       var id = this.coopTerms[i].studentId
      //
      //       AXIOS.get(`student/` + id)
      //         .then(res => {
      //           this.coopTerms[i].student = res.data
      //           this.coopTerms[i].studentName=this.coopTerms[i].student.name
      //         })
      //         .catch(e => {
      //           console.log("error in get student request:" + e);
      //           this.error = e;
      //         })
      //     }
      //   })

    }

  }

}
