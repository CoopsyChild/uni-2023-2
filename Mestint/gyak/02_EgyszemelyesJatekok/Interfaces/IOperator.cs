using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_EgyszemelyesJatekok.Interfaces
{
    public interface IOperator
    {
        bool IsApplicable(IState state);
        IState Apply(IState state);
    }
}
