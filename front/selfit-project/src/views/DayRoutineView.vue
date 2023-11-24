<template>
  <div class="button-container">
    <button
      @click="(perDay = day + `요일`), getPerDay()"
      v-for="day in days"
      :key="day"
    >
      {{ day }}
    </button>
  </div>
  <DayRoutine />
</template>

<script setup>
import DayRoutine from "@/components/myroutine/DayRoutine.vue";
import { ref, onMounted } from "vue";
import { getDayRoutineStore } from "@/stores/routine.js";
import { deleteDayRoutineStore } from "@/stores/routine.js";
import router from "@/router";

const perDay = ref("");
const data = ref({});

console.log(perDay.value);

const days = ref(["전체", "월", "화", "수", "목", "금", "토", "일"]);

const getDayRoutine = getDayRoutineStore();
const deleteDayRoutine = deleteDayRoutineStore();

const getPerDay = function () {
  if (perDay.value == "전체요일") {
    router.push({
      path: "/myroutine",
    });
  } else {
    router.push({
      path: "/dayroutine",
      state: {
        day: perDay.value,
      },
    });
  }
};

const deleteRoutineVideo = function (videoURL) {
  data.value = {
    videoId: videoURL,
    day: perDay.value,
  };
  console.log(data.value);
  deleteDayRoutine.deleteRoutineMethod(data.value);
};

onMounted(() => {
  getDayRoutine.dayRoutineMethod(perDay.value);
});
</script>

<style scoped>
.button-container {
  display: flex;
  justify-content: space-around; /* 버튼들 사이에 동일한 간격을 유지 */
  width: 60%; /* 전체 페이지의 70% 너비를 차지 */
  margin: 0 auto; /* 수평 중앙 정렬 */
  margin-bottom: 20px;
}

.button-container button {
  padding: 20px 30px;
  border: 1px solid #ccc;
  background-color: #fefefe;
  flex-grow: 0; /* 버튼 크기를 고정 */
  flex-shrink: 0; /* 화면 크기가 줄어들 때 버튼 크기 유지 */
  flex-basis: auto; /* 기본 버튼 크기 설정 */
  border-radius: 15px;
}
</style>
