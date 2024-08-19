<script setup>
import HealthCheck from './components/health_check/HealthCheck.vue'
import Income from './components/income/Income.vue';
</script>

<template>
  <div class="paragraph">
    <p>Hello! This is a budget planner!</p>
    <p>
      Here you can plan your budget whatever it is. You can add monthly and 
      "sudden" income and expenses. You can check the server status by the button below.
    </p>
  </div>
  <HealthCheck/>
  <Income/>

</template>

<style scoped>
p {
  line-height: 20px;
}

.paragraph {
  width: 30%;
  font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; 
  font-size: 14px; 
  font-style: normal; 
  font-variant: normal; 
  font-weight: 400; 
  line-height: 20px;
}
</style>
