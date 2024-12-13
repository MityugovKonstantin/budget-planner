<script setup>
import { compile, ref } from 'vue'

const page = ref(0)
const size = ref(5)

const response = ref('')
const incomeList = ref()


async function getIncomeData() {
    await fetch("http://localhost:8080/income/list?pageNumber=" + page.value + "&pageSize=" + size.value)
        .then(resp => {
            if (!resp.ok) throw new Error(resp.status)
            console.log('resp status is ok')
            return resp.text()
        })
        .then(respJson => {
            console.log('respJson is ' + respJson)
            incomeList.value = JSON.parse(respJson)
        })
        .catch(response.value = 'ХУЕТА!')
}
</script>

<template>
    <div class="paragraph">
        <p>Your incomes:</p>
        <ul title="Your incomes"><li v-for="income in incomeList" :key="income.id">{{ income.title }}</li></ul>
    </div>
    <button @click="getIncomeData()">Get income data</button>
</template>

<style scoped>
button {
    font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; 
    font-size: 14px; 
    font-style: normal; 
    font-variant: normal; 
    font-weight: 400;
}
.paragraph {
    font-family: Courier New, Courier, Lucida Sans Typewriter, Lucida Typewriter, monospace; 
    font-size: 14px; 
    font-style: normal; 
    font-variant: normal; 
    font-weight: 400;
}
</style>
