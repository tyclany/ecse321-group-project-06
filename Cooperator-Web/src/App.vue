<template>
  <div  id="app">
    <div class="site-wrap" style="height:100%;">
      <div class="site-mobile-menu">
        <div class="site-mobile-menu-header">
          <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>

          </div>
        </div>
        <div class="site-mobile-menu-body">
        </div>
      </div>

      <header v-show="this.$cookie.get('username')" class="site-navbar py-3" role="banner">
        <div class="container-fluid">
          <div class="row align-items-center">
            <div class="col-11 col-xl-2">
              <img src="./nameLogo2.png"/>
            </div>
            <div class="col-12 col-md-10 d-none d-xl-block">
              <nav class="site-navigation position-relative text-right" role="navigation">
                <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">
                  <li>
                    <router-link :to="{name: 'Home'}">Home</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Coopterms'}">Coopterms</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Events'}">Events</router-link>
                  </li>
                  <li>
                    <router-link :to="{name: 'Forms'}">Forms</router-link>
                  </li>
                  <li >
                    <b-button variant="outline-danger" @click="showModal">Log out</b-button>
                    <div>
                      <b-modal id="my-modal" ref="my-modal" hide-footer title="Log out">
                        <div class="d-block text-center">
                          <h3 style="font-size: 16px">You are about to log out of the system, are you sure?</h3>
                        </div>
                        <b-button class="mt-3" variant="outline-danger" block @click="logout">Logout</b-button>
                        <b-button class="mt-2" variant="outline-secondary" block @click="hideModal">Cancel</b-button>
                      </b-modal>
                    </div>
                  </li>
                </ul>
              </nav>
            </div>
            <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>
          </div>
        </div>
      </header>

      <router-view></router-view>


      <footer class="site-footer">
        <div class="container">
          <div class="row mb-5">
            <div class="col-md-4">
              <h2 class="footer-heading text-uppercase mb-4">About</h2>
              <p>A software system for managing co-op terms for co-op programs</p>
            </div>
            <div class="col-md-3 ml-auto">
              <h2 class="footer-heading text-uppercase mb-4">Quick Links</h2>
              <ul class="list-unstyled">
                <li><a href="https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06">About Us</a></li>
                <li><a href="mailto: chuning.li@mail.mcgill.ca">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-md-4">
              <h2 class="footer-heading text-uppercase mb-4">Connect with Us</h2>
              <p>
                <a href="https://www.facebook.com/McGillUniversity/" class="p-2 pl-0"><span class="icon-facebook"></span></a>
                <a href="https://twitter.com/mcgillu" class="p-2"><span class="icon-twitter"></span></a>
                <a href="https://github.com/McGill-ECSE321-Winter2019/ecse321-group-project-06" class="p-2"><span class="icon-github"></span></a>
              </p>
            </div>
          </div>
          <div class="row">

            <div class="col-md-12 text-center">
              <div class="border-top pt-5">
                <p style="color: #ffffff;">
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                  Copyright &copy; All rights reserved | This template is made with <i class="icon-heart text-primary" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                </p>
              </div>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </div>
</template>

<script>
export default {
  name: 'app',
  created: function () {
    console.log("cookie"+this.$cookie.get('username'));
  },
  methods:{
    logout(){
      this.$cookie.set('username', '');
      this.$cookie.set('password', '');
      this.$refs['my-modal'].hide()
      window.location.href = '/#/';
    },
    showModal() {
      this.$refs['my-modal'].show()
    },
    hideModal() {
      this.$refs['my-modal'].hide()
    }
  }
}
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Roboto+Mono);
@import 'style/css/bootstrap.min.css';
@import 'style/css/aos.css';
@import 'style/css/style.css';
@import 'style/css/magnific-popup.css';
@import 'style/fonts/icomoon/style.css';
@import 'style/css/owl.theme.default.min.css';
@import 'style/css/bootstrap-datepicker.css';
@import 'style/fonts/flaticon/font/flaticon.css';
</style>
