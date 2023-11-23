<template>
  <div class="about-us">
    <div class="div">
      <div class="text-wrapper">ABOUT US</div>
      <div class="group">
        <div class="text-wrapper-2">셀핏 소개
          <div class="sub-text">selfit은 개인화된 루틴을 만들 수 있는 서비스 입니다.</div>
        </div>
        <div class="text-wrapper-2">사용하는 법
          <div class="sub-text">유튜브에서 영상을 검색하여 시작시간과 끝시간을 입력하세요. 이거어케수정함</div></div>
        <div class="text-wrapper-2">기획자 소개
          <div class="sub-text">싸피 서울 8반 양동근 한재훈 swag</div></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutUs",
};
</script>

<style>
.about-us {
  background-color: #ffffff;
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 100%;
}

.about-us .div {
  background: linear-gradient(rgba(255, 255, 255, 0.5), rgba(255, 255, 255, 0.5)), url('src/assets/aboutus.jpg'); /* 배경 이미지에 투명도를 적용 */
  background-size: cover; /* 배경 이미지 크기 조절 */
  height: 1024px;
  position: relative;
  width: 1440px;
  display: flex;
  flex-direction: column;
}

.about-us .text-wrapper {
  color: #000000;
  font-family: "Bungee-Regular", Helvetica;
  font-size: 60px;
  letter-spacing: 0;
  line-height: normal;
  margin-left: 100px;
  white-space: nowrap;
  margin-bottom: 100px;
  margin-top: 30px;
}

.group {
  display: flex;
  justify-content: space-evenly;
  width: 100%;
  color: #000000;
  font-family: "Bungee-Regular", Helvetica;
  font-size: 60px;
  font-weight: 400;
  letter-spacing: 0;
  line-height: normal;
  position: relative;
  white-space: nowrap;
}
.group .sub-text{
  font-size: 20px;
  justify-content: center;
  margin-top: 20px;

}


</style>