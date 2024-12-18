
const express = require('express');
const cors = require('cors');
// ...existing code...

const app = express();

// Add CORS configuration
app.use(cors({
  origin: 'http://localhost:3000',
  credentials: true
}));

// ...existing code...

// Example route
app.post('/auth/login', (req, res) => {
  // ...existing login logic...
});