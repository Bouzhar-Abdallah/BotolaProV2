/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
  ],
  theme: {
    extend: {
      colors: {
        'darkBlue': '#0B2545',
        'lightBlue': '#00C6BD',
        'yellow': '#FFF7D6',
        'lightGray': '#E2F0FF',
        'darkGray': '#B2C2ED',
        'yellow': '#ffc82c',
        'gradient1': '#02EFFF',
        'gradient2': '#627BFF',
      },
    },
  },
  plugins: [
    require('tailwind-scrollbar'),
  ],
}

