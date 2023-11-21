<template>
  <div class="carousel-item text-center" :class="{ active: isActive }">
    <iframe
        :src="videoURL"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        allowfullscreen
    ></iframe>
    <h6 class="text-center">{{ videoTitle }}</h6>
    <button class="btn btn-dark add-to-cart-btn" @click="addToCart(video)">
      담기
    </button>
  </div>
</template>

<script setup>
import { computed } from "vue";
import _ from "lodash";

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
</script>

<style scoped>

</style>
