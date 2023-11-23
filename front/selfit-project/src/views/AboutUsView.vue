<template>
  <h1>SSAFY 10기 서울 8반 사랑해 💙🧡💛</h1>
  <div class="about-us">
    <div class="div">

    </div>
  </div>
</template>

<script>
export default {
  name: "AboutUs",
};
</script>

<style>
h1{
  margin-left: 31%;
  margin-bottom: 30px;

}

.about-us {
  background-color: #ffffff;
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 100%;
}

.about-us .div {
  background: linear-gradient(rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.1)), url('src/assets/aboutus.jpg'); /* 배경 이미지에 투명도를 적용 */
  background-size: cover; /* 배경 이미지 크기 조절 */
  height: 1024px;
  position: relative;
  width: 1440px;
  display: flex;
  flex-direction: column;
}



</style>