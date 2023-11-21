<template>
    <div>
      <span v-if="chk">
        <THeHeaderNav />
      </span>
      <button @click="chk = !chk">on/off</button>
      <RouterView />

    </div>
</template>

<script setup>
import THeHeaderNav from "./components/common/THeHeaderNav.vue";
import { ref } from "vue";
const chk = ref(true);
</script>

<style scoped></style>
