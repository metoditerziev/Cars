import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/main.css'
import Dropdown from "primevue/dropdown";
import PrimeVue from "primevue/config";
import Ripple from "primevue/ripple";

const app = createApp(App)

app.use(router)
app.use(PrimeVue, { ripple: true });
app.directive("ripple", Ripple);
app.mount('#app')
app.component("Dropdown", Dropdown);

