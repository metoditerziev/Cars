 <script setup>
    import { RouterLink, RouterView } from 'vue-router'
    import InputText from 'primevue/inputtext';
    import Button from 'primevue/button';
  </script>

  <template>
    <h1>Better Cars</h1>
    <div style="width: 330px; height:270px; border: 2px solid #222222; border-radius: 20px">
      <div style="margin-left: 40px; margin-top: 50px;">
        <h3>Email Adress</h3>
        <InputText  class="input" placeholder="Enter your email adress"></InputText>
        <h3 style="margin-top: 10px">Password</h3>
        <InputText class="input" placeholder="Enter your password"></InputText>
        <div style=" margin-top: 15px; margin-left:55px;display: flex; flex-direction: column">
          <RouterLink to="/cars" class="button">Log In </RouterLink>
          <RouterLink to="/about">Register</RouterLink>
        </div>
      </div>
    </div>
  </template>

  <style scoped>
  .button[data-v-14d3142e] {
    width: 100px;
    height: 24px;
    background: #E0010B;
    box-shadow: 3px 5px 25px rgb(0 0 0 / 15%);
    border-radius: 8px;
    font-weight: 800;
    text-transform: uppercase;
    color: #FFFFFF;
    border: none;
    padding-left: 20px;
  }

    .input{
      padding-left: 50px;
      height: 34px;
      background: #FFFFFF;
      border: 1px solid #E0E0E0;
      box-sizing: border-box;
      box-shadow: 0px 1px 4px rgba(0, 0, 0, 0.05);
      border-radius: 10px;
    }
  </style>
