<template>
  <div class="car">
    <div style="display: flex;  gap: 20px; margin-top:110px; margin-left: 25px">
      <div style="color:red; border-radius: 6px; border: 1px solid red; padding: 3px">BMW x5</div>
      <div style="color:red; border-radius: 6px; border: 1px solid red; padding: 3px">15000 Euro </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";

export default {
  setup() {

    const products = ref();

    return {
      products
    }
  }
}
</script>

<style lang="scss" scoped>
.car {
  width: 200px;
  height: 150px;
  background-color: #222222;
  border-radius: 20px;
}
</style>
