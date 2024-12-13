<script setup>
import { ref } from 'vue'

const ServerStatus = {
    NO_CALL: 'No checks have been performed yet.',
    ERROR: 'The server has problems.',
    OK: 'The server is okay.'
}

const currentServerStatus = ref(ServerStatus.NO_CALL)

async function checkServerStatus() {
    await fetch("http://localhost:8080/health-check")
        .then(resp => {
            if (!resp.ok) throw new Error(resp.status)
            currentServerStatus.value = ServerStatus.OK
        })
        .catch(() => currentServerStatus.value = ServerStatus.ERROR)
}
</script>

<template>
    <div class="paragraph">
        <p><button @click="checkServerStatus()">Check server status</button> {{ currentServerStatus }}</p>
    </div>
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
