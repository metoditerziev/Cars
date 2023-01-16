<template>
  <div class="vehicles" v-for="vehicle in vehicles">{{ vehicle?.year }}, {{ vehicle.brand?.brand_name }}
    {{ vehicle?.region.region_name}}  {{ vehicle?.region.region_name}}  {{vehicle?.km_driven }} km</div>
  <div class="register-container">
    <div style="display: flex; flex-direction: column">
    <h1>Enter a car</h1>
    <div class="column">
    <h2>Car's Brand</h2>
    <Dropdown  :options="brandOptions" v-model="brand" optionLabel="brand_name" placeholder="Select Brand" />
    </div>
    <div class="column">
    <h2>Car's year</h2>
    <InputNumber class="input" v-model="year" placeholder="Enter year"></InputNumber>
    </div>
    <div class="column">
    <h2> Category</h2>
    <Dropdown  class="input" :options="categoryOptions" v-model="category" placeholder="Enter category"></Dropdown>
      </div>
    <div class="column">
    <h2>Car's descriptions</h2>
    <InputText  class="input" v-model="description" placeholder="description"></InputText>
    </div>
    <div class="column">
    <h2>Car's price</h2>
    <InputNumber class="input" v-model="price" placeholder="price"></InputNumber>
    </div>
    </div>
    <div>
    <div class="column">
    <h2>Car's gearbox</h2>
    <Dropdown  class="input" :options="GearBoxes" v-model="gearbox" placeholder="gearbox"></Dropdown>
    </div>
    <div class="column">
    <h2>Car's engine</h2>
    <Dropdown  class="input" v-model="engine" :options="engineOptions" placeholder="engine"></Dropdown>
    </div>
      <div class="column">
        <h2>Car's KM Driven</h2>
        <InputNumber class="input" v-model="kmDriven" placeholder="kmDriven"></InputNumber>
      </div>
    <div class="column">
    <h2> Region</h2>
    <Dropdown class="input" v-model="region" optionLabel="region_name" :options="regionOptions" placeholder="region"></Dropdown>
    </div>
    <div class="column">
    <h2> Extras</h2>
    <MultiSelect :options="extrasOptions" optionLabel="extra_type" class="input" v-model="extras" placeholder="extras"></Multiselect>
      <Button class="button"  @click="sendCar">Register</Button>
    </div>
    </div>

  </div>
</template>

<script lang="ts">
import Dropdown from 'primevue/dropdown';
import Button from 'primevue/button';
import { defineComponent, ref } from "vue";
import { RouterLink, RouterView } from 'vue-router'
import InputText from "primevue/inputtext";
import InputNumber from "primevue/inputnumber";
import axios from 'axios'
import MultiSelect from "primevue/multiselect";


export default defineComponent({
  name: 'ContentItems',

  components: { Button, RouterLink, RouterView, InputText, InputNumber, Dropdown, MultiSelect },

  props: {
    user: Object,
    car: Object,
  },


  setup(props) {
    const car = ref();
    const year = ref ();
    const category = ref();
    const kmDriven = ref();
    const description = ref();
    const price = ref();
    const gearbox = ref();
    const engine = ref();
    const model = ref();
    const region = ref();
    const extras = ref();
    const brand = ref();
    const brandOptions = ref();
    const type = ref ();
    const user = ref();
    const regionOptions = ref();
    const categoryOptions = ref();
    const GearBoxes = ref();
    const extrasOptions = ref();
    const engineOptions = ref();
    const users = ref([]);
    const vehicles = ref();
    const getBrand = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/brands', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            brandOptions.value = response.data
            console.log(brandOptions.value, 'Brand')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const getVehicals = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/all_vehicles', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            vehicles.value = response.data
            console.log(brandOptions.value, 'Brand')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const getExtras = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/extras', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            extrasOptions.value = response.data
            console.log( extrasOptions, 'regionOptions')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const getcategoryOptions = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/categories', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            categoryOptions.value = response.data
            console.log( categoryOptions, 'regionOptions')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const getGearBoxes = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/gearboxes', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            GearBoxes.value = response.data
            console.log( GearBoxes, 'regionOptions')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const getEngines = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/engines', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            engineOptions.value = response.data
            console.log( engineOptions, 'regionOptions')
          })
          .catch(error => {
            console.log(error)
          })
    }
    const getRegions = async () => {
      await axios({method: 'get', url: 'http://localhost:8080/vehicle/regions', config: {
          headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
            "Access-Control-Allow-Headers": "Origin, Content-Type, X-Auth-Token"
          }}})
          .then(response => {
            regionOptions.value = response.data
            console.log( regionOptions, 'regionOptions')
          })
          .catch(error => {
            console.log(error)
          })
    }
    window.onload = getRegions() as any
    window.onload = getBrand() as any
    window.onload = getcategoryOptions() as any
    window.onload = getEngines() as any
    window.onload = getGearBoxes() as any
    window.onload = getExtras() as any
    window.onload = getVehicals() as any
    const sendCar = async () => {
      const car = {
        year: year.value,
        category: category.value,
        kmDriven: kmDriven.value,
        description: description.value,
        price: price.value,
        gearbox: gearbox.value,
        engine: engine.value,
        model: '5 series',
        region: region.value.regionName,
        // extras: extras.value,
        extras: ['STOVE'],
        brand: brand.value.brand_name,
        horsepower: 300,
        type: 'CAR',
        username: 'meto',
      }
      console.log(car);
      window.location.reload();
      try {
        const response = await axios.post('http://192.168.1.6:8080/vehicle/register_vehicle', car);
        console.log(response);
      } catch (error) {
        console.error(error);
      }
    }

    return {
      vehicles,
      getVehicals,
      getEngines,
      engineOptions,
      getExtras,
      extrasOptions,
      getGearBoxes,
      GearBoxes,
      getcategoryOptions,
      categoryOptions,
      getRegions,
      regionOptions,
      brandOptions,
      sendCar,
      getBrand,
      brand,
      car,
      year,
      category,
      kmDriven,
      description,
      price,
      gearbox,
      engine,
      model,
      region,
      extras,
      type,
      user,
      users,
    };
  },
  methods: {
    async apiCall(searchTerm) {
      this.users = [
        { name: "Anne", id: "001" },
        { name: "Bobby", id: "002" },
        { name: "Charles", id: "003" },
      ].filter(
          (x) =>
              x.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
              x.id.toLowerCase().includes(searchTerm.toLowerCase())
      );
    },
  },
  mounted() {
    this.apiCall("");
  },
});
</script>

<style scoped>
.vehicles {
  top: -27px;
  left: -416px;
  border: 1px solid red;
  border-radius: 9px;
  padding: 2px;
}
.register-container {
  display: flex;
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
.column {
  display: flex;
  flex-direction: column;
}
::v-deep(.p-dropdown-items-wrapper) {
  background-color: #222222;
}
</style>
