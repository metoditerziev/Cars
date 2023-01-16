<template>
  <div class="register-container">
    <h1> REGISTER</h1>
    <h2> User name</h2>
   <InputText  class="input" v-model="enteredUsername" placeholder="Enter username"></InputText>
    <h2> Email Address</h2>
   <InputText  class="input" v-model="enteredEmailAddress" placeholder="Enter email address"></InputText>
    <h2> Password</h2>
   <InputText  class="input" v-model="enteredPassword" placeholder="Enter password"></InputText>
   <InputText  class="input" v-model="enteredPasswordSecond" placeholder="Repeat your password"></InputText>
    <h2> Phone number</h2>
    <InputNumber class="input" v-model="enteredPhoneNumber" placeholder="Phone number"></InputNumber>
    <RouterLink class="button"  @click="sendUser" to="/">Register</RouterLink>
  </div>

</template>

<script lang="ts">
import Button from 'primevue/button';
import { defineComponent, ref } from "vue";
import { RouterLink, RouterView } from 'vue-router'
import InputText from "primevue/inputtext";
import InputNumber from "primevue/inputnumber";
import axios from 'axios'


export default defineComponent({
  name: 'ContentItems',

  components: { Button, RouterLink, RouterView, InputText, InputNumber },

  props: {
    user: Object,
  },

  setup(props) {
    const config  = ref()
    const enteredPassword = ref();
    const enteredPasswordSecond = ref();
    const enteredUsername = ref();
    const enteredEmailAddress = ref();
    const enteredPhoneNumber = ref();
    const brand = ref();

    const getBrand = async () => {
         await axios({method: 'get', url: 'http://localhost:8080/vehicle/brands', config: {
             headers: {
               "Access-Control-Allow-Origin": "*",
               "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
               "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
             }}})
          .then(response => {
            brand.value = response.data
            console.log(brand.value, 'Brand')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const sendUser = async () => {
      const user = {
        password: enteredPassword.value,
        username: enteredUsername.value,
        repeatedPassword: enteredPasswordSecond.value,
        mobilePhone: enteredPhoneNumber.value,
        email: enteredEmailAddress.value,
      }
      try {
        const response = await axios.post('http://localhost:8080/user/register', user);
        console.log(response);
      } catch (error) {
        console.error(error);
      }
    }

    return {
      sendUser,
      getBrand,
      brand,
      enteredPassword,
      enteredPasswordSecond,
      enteredUsername,
      enteredEmailAddress,
      enteredPhoneNumber,
      config,
    };
  },
});
</script>

<style scoped>
.register-container {
  display: flex;
  flex-direction: column;
  border:2px solid #222222;
  padding: 20px;
  border-radius: 10px;
}
.button {
  width: 100px;
  height: 25px;
  padding-left: 15px;
  background: #E0010B;
  box-shadow: 3px 5px 25px rgba(0, 0, 0, 0.15);
  border-radius: 8px;
  font-weight: 800;
  text-transform: uppercase;
  color: #FFFFFF;
  border: none;
}

.input {
  height: 34px;
  width: 180px;
  background: #FFFFFF;
  border: 1px solid #E0E0E0;
  box-sizing: border-box;
  box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.05);
  border-radius: 10px;
}
</style>
