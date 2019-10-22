window.onload = function() {
    // Get all the DOM elements we need
    const resultEl = document.getElementById('result');
    const lengthEl = document.getElementById('length');
    const uppercaseEl = document.getElementById('uppercase');
    const lowercaseEl = document.getElementById('lowercase');
    const numbersEl = document.getElementById('numbers');
    const symbolsEl = document.getElementById('symbols');
    const generateEl = document.getElementById('generate');
    const clipboardEl = document.getElementById('clipboard');

    /**
     * Object to reference the random functions
     */
    const randomFunc = {
        lower: getRandomLower,
        upper: getRandomUpper,
        number: getRandomNumber,
        symbol: getRandomSymbol
    };

    clipboardEl.addEventListener('click', () => {
        const el = document.createElement('textarea');
        const password = resultEl.innerHTML;
        el.value = password;
        el.setAttribute('readonly', '');
        el.style.position = 'absolute';
        el.style.left = '-9999px';
        document.body.appendChild(el);
        el.select();
        document.execCommand('copy');
        document.body.removeChild(el);
    })

    /**
     * Event listener for the 'generate' element that runs when clicked.
     */
    generateEl.addEventListener('click', () => {
        const length = +lengthEl.value;  // the + is a simple ParseInt
        const hasLower = lowercaseEl.checked;
        const hasUpper = uppercaseEl.checked;
        const hasNumber = numbersEl.checked;
        const hasSymbol = symbolsEl.checked;

        resultEl.innerText = generatePassword(hasLower, hasUpper, hasNumber, hasSymbol, length);
    });

    /**
     * Generates a password of the given length with letters, numbers, or symbols as defined by the user.
     * Uses the randomFunc object to get a random character. Performs the following actions:
     * 1. Initializes password variable.
     * 2. Filters out the unchecked types of characters.
     * 3. Picks random valid chars in a loop to get to the desired length.
     * 4. Adds the chars to the password and returns the generated password.
     * Returns the password as a string.
     * @param {boolean} hasLower 
     * @param {boolean} hasUpper 
     * @param {boolean} hasNumber 
     * @param {boolean} hasSymbol 
     * @param {int} length
     */
    function generatePassword(lower, upper, number, symbol, length) {
        if (!lower && !upper && !number && !symbol) return "";
        let generatedPassword = "";
        // Wrapping in {} makes this like [{lower: true}, {upper: true}, ...]  (if lower and upper are checked)
        let typesArr = [{lower}, {upper}, {number}, {symbol}];
        typesArr = typesArr.filter(typeObj => Object.values(typeObj)[0]);
        for (let i = 0; i < length; i++) {
            let t = Math.floor(typesArr.length * Math.random());
            let r_type = Object.keys(typesArr[t])[0];
            let r_char = randomFunc[r_type]();
            generatedPassword += r_char;
        }
        return generatedPassword;
    }

    /**
     * Function to get a random lowercase letter.
     * Returns a single lowercase letter.
     */
    function getRandomLower() {
        return String.fromCharCode(97 + Math.floor(Math.random() * 26));
    }

    /**
     * Function to get a random uppercase letter.
     * Returns a single uppercase letter.
     */
    function getRandomUpper() {
        return String.fromCharCode(65 + Math.floor(Math.random() * 26));
    }

    /**
     * Function to get a random number (0 - 9).
     * Returns a single number (0 - 9).
     */
    function getRandomNumber() {
        return String.fromCharCode(48 + Math.floor(Math.random() * 10));
    }

    /**
     * Function to get a random symbol.
     * Returns a single number (0 - 9).
     */
    function getRandomSymbol() {
        const symbols = "!@#$%^&*()[]{}-=;:<>,./?~`";
        return symbols[Math.floor(Math.random()*symbols.length)];
    }
}
