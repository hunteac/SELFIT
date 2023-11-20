<template>
  <div class="container">
    <h4 class="text-center" v-if="!store.videos || store.videos.length === 0">
      <br>
      <br>
      아직 검색된 결과가 없습니다.
      <br>검색어를 입력해주세요.
    </h4>
    <div v-else>
      <div id="youtube-carousel" class="carousel slide carousel-dark">
        <div class="carousel-inner">
          <div class="carousel-item" :class="{ active: index === currentGroup }" v-for="(group, index) in videoGroups"
               :key="index">
            <div class="row">
              <div class="col-md-6" v-for="video in group" :key="video.id.videoId">
                <YoutubeVideoListItem
                    :video="video"
                    :active="index === currentGroup"
                />
              </div>
            </div>
          </div>
        </div>

        <button class="carousel-control-prev" type="button" data-bs-target="#youtube-carousel" data-bs-slide="prev" @click="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#youtube-carousel" data-bs-slide="next" @click="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  </div>

</template>

<script setup>
import YoutubeVideoListItem from "@/components/youtube/YoutubeVideoListItem.vue";
import {useYoutubeStore} from "@/stores/youtube";
import {ref, computed} from 'vue'

const store = useYoutubeStore();
const currentGroup = ref(0);

const videoGroups = computed(() => {
  const groups = [];
  for (let i = 0; i < store.videos.length; i += 4) { // Change 9 to 4
    groups.push(store.videos.slice(i, i + 4));
  }
  return groups;
});

const prev = function () {
  if (currentGroup.value > 0) {
    currentGroup.value--;
  }
}

const next = function () {
  if (currentGroup.value < videoGroups.value.length - 1) {
    currentGroup.value++;
  }
}
</script>

<style scoped>

#youtube-carousel {
  position: relative;
}
.carousel-control-prev, .carousel-control-next {
  position: absolute;
  top: 50%; /* Adjust vertically to align with the middle of the carousel */
  transform: translateY(-50%);
  z-index: 10; /* Ensure they are above other content */
}

.carousel-control-prev {
  left: -100px; /* Adjust as needed to move outside the grid */
}

.carousel-control-next {
  right: -100px; /* Adjust as needed to move outside the grid */
}
.carousel-control-prev {
  color: red;
  font-size: 24px;
}
.carousel-control-next {
  color: red;
  font-size: 24px;
}

</style>
