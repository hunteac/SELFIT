<template>
  <div class="video-container">
    <h2 class="text-center"><i class="bi bi-youtube" style="color: red;"></i> 유튜브 검색</h2>
    <br>
    <YoutubeVideoSearch />
    <br>
    <br>
    <YoutubeVideoList />
  </div>
</template>

<script setup>
import YoutubeVideoSearch from '@/components/youtube/YoutubeVideoSearch.vue';
import YoutubeVideoList from '@/components/youtube/YoutubeVideoList.vue';
</script>

<style scoped></style>
