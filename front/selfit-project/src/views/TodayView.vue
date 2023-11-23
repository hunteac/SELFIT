<template>
  <div>
    <div class="upline">
      <div class="tmp">O요일의 운동 리스트</div>
      <img class="img" src="src/assets/youngcha.png" alt="selfit" @click="pushStart"/>
    </div>
    
    <br>
    <br>

    <FitPerDay class="fit-per-day" />
  </div>
</template>

<script setup>
import FitPerDay from "@/components/today/FitPerDay.vue";

import router from "@/router";
const pushStart = function () {
  router.push("start");
};
</script>
<style scoped>
.upline{
  display: flex;
  flex-direction: row;
  align-content: center;
  justify-content: center;
  cursor: pointer;

}
.tmp{
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em;
  color: #4a4a4a;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);

}
.img{
  margin-left: 30px;
  width:100px;
  height: 120px;
}
.fit-per-day {
  max-width: 1000px;
  margin: 0 auto;
}
</style>
