<template>
    <div>


      <hr>
      <br>

        <h2>오늘의 운동</h2>
    </div>
  <div class="today-fit">
    <div class="overlap-group-wrapper">
      <div class="overlap-group">
        <div class="rectangle" />
        <div class="div" />
        <div class="rectangle-2" />
        <div class="rectangle-3" />
        <div class="rectangle-4" />
        <div class="text-wrapper">30 SEC</div>
        <div class="text-wrapper-2">FRIDAY !</div>
        <div class="rectangle-5" />
        <div class="text-wrapper-3">15 SEC</div>
        <div class="group" />
        <div class="text-wrapper-4">START</div>
        <img class="arrow" alt="Arrow" src="arrow-1.svg" />
        <img class="img" alt="Arrow" src="arrow-2.svg" />
        <div class="rectangle-6" />
        <div class="rectangle-7" />
      </div>
    </div>
  </div>
</template>

<script setup>

</script>
<style scoped>
.content {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* 전체 뷰포트 높이 */
  text-align: center;
}

h2 {  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2em; /* 폰트 크기 */
  color: #4a4a4a; /* 폰트 색상 */
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); /* 텍스트 그림자 효과 */
}
.today-fit {
  background-color: #ffffff;
  display: flex;
  flex-direction: row;
  justify-content: center;
  width: 100%;
}

.today-fit .overlap-group-wrapper {
  background-color: #ffffff;
  height: 1024px;
  width: 1440px;
}

.today-fit .overlap-group {
  height: 734px;
  left: 34px;
  position: relative;
  top: 238px;
  width: 1356px;
}

.today-fit .rectangle {
  background-color: #cddbec80;
  border: 1px solid;
  border-color: #0000004c;
  height: 516px;
  left: 34px;
  position: absolute;
  top: 105px;
  width: 401px;
}

.today-fit .div {
  background-color: #cddbec80;
  border: 1px solid;
  border-color: #0000004c;
  height: 516px;
  left: 920px;
  position: absolute;
  top: 105px;
  width: 401px;
}

.today-fit .rectangle-2 {
  background-color: #cddbecb2;
  border: 1px solid;
  border-color: #0000004c;
  box-shadow: 0px 4px 4px #00000040;
  height: 619px;
  left: 182px;
  position: absolute;
  top: 53px;
  width: 481px;
}

.today-fit .rectangle-3 {
  background-color: #cddbecb2;
  border: 1px solid;
  border-color: #0000004c;
  box-shadow: 0px 4px 4px #00000040;
  height: 619px;
  left: 698px;
  position: absolute;
  top: 53px;
  width: 481px;
}

.today-fit .rectangle-4 {
  background-color: #cddbeb;
  border: 1px solid;
  border-color: #1715154c;
  box-shadow: 0px 4px 4px #00000040;
  height: 734px;
  left: 398px;
  position: absolute;
  top: 0;
  width: 578px;
}

.today-fit .text-wrapper {
  color: #000000;
  font-family: "Coda-Regular", Helvetica;
  font-size: 30px;
  font-weight: 400;
  left: 634px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 586px;
  width: 107px;
}

.today-fit .text-wrapper-2 {
  color: #000000;
  font-family: "Coda-Regular", Helvetica;
  font-size: 50px;
  font-weight: 400;
  left: 460px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 16px;
  width: 185px;
}

.today-fit .rectangle-5 {
  background-color: #ffffff;
  height: 46px;
  left: 946px;
  position: absolute;
  top: 126px;
  width: 22px;
}

.today-fit .text-wrapper-3 {
  color: #000000;
  font-family: "Coda-Regular", Helvetica;
  font-size: 30px;
  font-weight: 400;
  left: 634px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 299px;
  width: 107px;
}

.today-fit .group {
  background-color: #d9d9d9;
  height: 58px;
  left: 754px;
  position: absolute;
  top: 20px;
  width: 168px;
}

.today-fit .text-wrapper-4 {
  color: #000000;
  font-family: "Coda-Regular", Helvetica;
  font-size: 30px;
  font-weight: 400;
  left: 796px;
  letter-spacing: 0;
  line-height: normal;
  position: absolute;
  top: 32px;
}

.today-fit .arrow {
  height: 37px;
  left: 1288px;
  position: absolute;
  top: 335px;
  width: 68px;
}

.today-fit .img {
  height: 37px;
  left: 0;
  position: absolute;
  top: 335px;
  width: 68px;
}

.today-fit .rectangle-6 {
  background-color: #d9d9d9;
  height: 161px;
  left: 512px;
  position: absolute;
  top: 113px;
  width: 374px;
}

.today-fit .rectangle-7 {
  background-color: #d9d9d9;
  height: 161px;
  left: 512px;
  position: absolute;
  top: 382px;
  width: 374px;
}
</style>