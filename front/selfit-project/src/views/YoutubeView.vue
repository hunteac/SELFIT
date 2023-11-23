<template>
  <div class="video-container">
    <h3 class="text-center">
      <i class="bi bi-youtube" style="color: red"></i> 유튜브 검색
    </h3>
    <br />
    <YoutubeVideoSearch />
    <br />
    <br />
    <YoutubeVideoList class="ytlist" />
  </div>
</template>

<script setup>
import YoutubeVideoSearch from "@/components/youtube/YoutubeVideoSearch.vue";
import YoutubeVideoList from "@/components/youtube/YoutubeVideoList.vue";
</script>

<style scoped>


</style>
