<template>
    <div>
      <span v-if="chk">
        <THeHeaderNav />
      </span>
    </div>
    <span class="button-container">
      <button  @click="chk = !chk">{{ chk ? '올리기' : '내리기' }}</button>
    </span>
  <hr>
  <br>
  <RouterView />
</template>

<script setup>
import THeHeaderNav from "./components/common/THeHeaderNav.vue";
import { ref } from "vue";
const chk = ref(true);
</script>

<style scoped>

.button-container{
  display: flex;
  justify-content: center;
}
</style>
