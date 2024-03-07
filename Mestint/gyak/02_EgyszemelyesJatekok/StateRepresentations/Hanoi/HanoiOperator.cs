﻿using _02_EgyszemelyesJatekok.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02_EgyszemelyesJatekok.StateRepresentations.Hanoi
{
    public class HanoiOperator : IOperator
    {
        public int From { get; set; }
        public int To { get; set; }

        public HanoiOperator(int from, int to)
        {
            From = from;
            To = to;
        }

        public IState Apply(IState state)
        {
            if (state == null || state is not HanoiState)
                throw new Exception("Not Hanoi state");

            HanoiState newState = state.Clone() as HanoiState;

            newState.Discs[GetFromIndex(newState)] = To;

            return newState;
        }

        public bool IsApplicable(IState state)
        {
            if (state == null || state is not HanoiState)
                throw new Exception("Not Hanoi state");

            HanoiState hanoiState = state as HanoiState;

            return From != To &&
                FromPoleHasAnyDisc(hanoiState) &&
                !ToPoleHasSmallerDiscs(hanoiState);
        }

        private bool FromPoleHasAnyDisc(HanoiState state)
        {
            return GetFromIndex(state) > -1;
        }

        private int GetFromIndex(HanoiState state)
        {
            for (int i = 0; i < HanoiState.DiscsNumber; i++)
            {
                if (state.Discs[i] == From)
                    return i;
            }

            return -1;
        }

        private bool ToPoleHasSmallerDiscs(HanoiState state)
        {
            for (int i = GetFromIndex(state) - 1; i >= 0; i--)
            {
                if (state.Discs[i] == To)
                    return true;
            }

            return false;
        }
    }
}
