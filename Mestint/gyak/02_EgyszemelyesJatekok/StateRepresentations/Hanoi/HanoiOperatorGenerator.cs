using _02_EgyszemelyesJatekok.Interfaces;

namespace _02_EgyszemelyesJatekok.StateRepresentations.Hanoi
{
    public class HanoiOperatorGenerator : IOperatorGenerator
    {
        public List<IOperator> Operators { get; }

        public HanoiOperatorGenerator()
        {
            Operators = [];

            for (int i = 0; i < 3; i++) 
            {
                for (int j = 0; j < 3; j++)
                {
                    if(i != j)
                    {
                        Operators.Add(new HanoiOperator(i, j));
                    }
                }

            }
        }
    }
}
