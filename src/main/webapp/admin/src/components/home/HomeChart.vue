<template>
  <div id="home-chart" style="width:100%;height:400px;"></div>
</template>
<script>
export default {
  mounted() {
    this.homeChart();
  },
  methods: {
    homeChart() {

      var myChart = this.$echarts.init(document.getElementById("home-chart"));

      var option = {
        tooltip: {
          trigger: "axis"
        },
        legend: {
          data: ["visit", "User", "income"]
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: [
            "1 month",
            "2 month",
            "3 month",
            "4 month",
            "5 month",
            "6 month",
            "7 month",
            "8 month",
            "9 month",
            "10 month",
            "11 month",
            "12 month"
          ]
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            name: "visit",
            type: "line",
            stack: "total",
            data: [
              120,
              132,
              101,
              134,
              90,
              230,
              210,
              120,
              132,
              101,
              134,
              90,
              230
            ]
          },
          {
            name: "User",
            type: "line",
            stack: "total",
            data: [
              220,
              182,
              191,
              234,
              290,
              330,
              310,
              182,
              191,
              234,
              290,
              330,
              310
            ]
          },
          {
            name: "income",
            type: "line",
            stack: "total",
            data: [
              150,
              232,
              201,
              154,
              190,
              330,
              410,
              232,
              201,
              154,
              190,
              330,
              410
            ]
          }
        ]
      };

      myChart.setOption(option);

      window.onresize = function() {
        myChart.resize();
      };
    }
  }
};
</script>
<style lang="scss" scoped>
#home-chart {
  background: #ffffff;
  padding: 20px 0;
}
</style>
