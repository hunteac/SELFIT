<template>
    <div>
        <div class="text-center">

        </div>
        <RouterView />
    </div>
</template>
  
<script setup>
import { RouterView } from "vue-router";
</script>
  
<style scoped>
.my-h2 {
    display: inline-block
}

.my-underline {
    background: linear-gradient(to top, #54ddff 20%, transparent 30%);
}
</style>
  