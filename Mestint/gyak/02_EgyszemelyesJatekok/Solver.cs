using _02_EgyszemelyesJatekok.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_EgyszemelyesJatekok
{
    public abstract class Solver(IOperatorGenerator operatorGenerator)
    {
        public IOperatorGenerator OperatorGenerator { get; set; } = operatorGenerator;

        public abstract void Solve();
    }
}
