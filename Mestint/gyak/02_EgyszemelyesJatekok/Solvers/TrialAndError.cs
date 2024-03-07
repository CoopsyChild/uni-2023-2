using _02_EgyszemelyesJatekok.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace _02_EgyszemelyesJatekok.Solvers
{
    public class TrialAndError(IOperatorGenerator generator, IState startingState) : Solver(generator)
    { 
        private Random rnd = new();

        public IState CurrentState = startingState;

        private int[] GetRandomIndexes()
        { 
            List<int> indexes = [];

            while (indexes.Count < OperatorGenerator.Operators.Count)
            {
                int number;
                do
                {
                    number = rnd.Next(0, OperatorGenerator.Operators.Count);

                }
                while (indexes.Contains(number));
                indexes.Add(number);
            }

            return [.. indexes];
        }

        private IOperator SelectOperator()
        {
            int[] indexes = GetRandomIndexes();

            foreach(int index in indexes) 
            {
                if (OperatorGenerator.Operators[index].IsApplicable(CurrentState)){
                    return OperatorGenerator.Operators[index];
                }
            }

            throw new Exception("Dead End");
        }

        public override void Solve()
        {
            int step = 0;
            Console.WriteLine($"Step: {step}\n");
            Console.WriteLine(CurrentState);
            Console.WriteLine("-----------------------------------------");

            while (!CurrentState.IsTargetState())
            {
                step++;
                IOperator @operator = SelectOperator();
                CurrentState = @operator.Apply(CurrentState);
                Console.WriteLine($"Step: {step}\n");
                Console.WriteLine(CurrentState);
                Console.WriteLine("-----------------------------------------");
            }

            Console.WriteLine("Solved");

        }
    }
}
