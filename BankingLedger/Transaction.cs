using System;

namespace BankingLedger
{
    class Transaction
    {
        private readonly string time;
        private readonly string type;
        private readonly double value;
        private readonly double balance;

        /// <summary>
        /// Constructs a new transaction instance.
        /// </summary>
        /// <param name="type">Either "deposit" or "withdraw"</param>
        /// <param name="value">The amount deposited or withdrawn.</param>
        /// <param name="balance">Account balance after the transaction.</param>
        public Transaction(string type, double value, double balance)
        {
            this.time = DateTime.Now.ToString();
            this.type = type;
            this.value = value;
            this.balance = balance;
        }

        /// <summary>
        /// Formats the transaction as the string:
        /// type   value   balance
        /// </summary>
        /// <returns>Returns the transaction as a string.</returns>
        public override string ToString()
        {
            if (this.type == "withdraw")  // One less tab character
            {
                return $"{this.time}\t{this.type}\t{this.value}\t{this.balance}";
            }
            return $"{this.time}\t{this.type}\t\t{this.value}\t{this.balance}";
        }
    }
}
