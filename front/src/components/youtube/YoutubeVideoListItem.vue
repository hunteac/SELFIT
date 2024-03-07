<template>
  <div class="carousel-item text-center" :class="{ active: isActive }">
    <iframe
      :src="videoURL"
      class="video-frame"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowfullscreen
    ></iframe>
    <h6 class="text-center">{{ videoTitle }}</h6>
    <button @click="select" class="btn btn-dark add-to-cart-btn">찜하기</button>
  </div>
</template>

<script setup>
import { computed, ref } from "vue";
import { useVideoStore } from "@/stores/youtube.js";
import _ from "lodash";

const videoStore = useVideoStore();
const data = ref({});

const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
  index: Number,
  current: Number,
  active: Boolean,
});

const videoURL = computed(() => {
  const videoId = props.video.id.videoId;
  return `https://www.youtube.com/embed/${videoId}`;
});

const isActive = computed(() => props.current === props.index);

const videoTitle = computed(() => {
  return _.unescape(props.video.snippet.title);
});

const select = function () {
  data.value = {
    userId: sessionStorage.getItem("loginId"),
    videoId: videoURL.value,
  };
  console.log(data.value);
  videoStore.videoMethod(data.value);
};
</script>

<style scoped>

.btn{
  margin-bottom: 30px;
}
.video-frame {
  width: 600px; /* 너비 최대로 설정 */
  height: 300px; /* 높이 조정, 필요에 따라 변경 가능 */
  border: none; /* 테두리 제거 */

}
.text-center{
  font-size:15px;
  margin-bottom: 10px;
}
</style>
