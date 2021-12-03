from typing import List, Tuple

def get_max_score(intervals: List[Tuple[int, int]], scores: List[int]):
    assert len(scores) == len(intervals)

    N = len(scores)
    LEFT = 0
    RIGHT = 1

    # Sort by left endpoint.
    intervals = sorted(intervals, key=lambda x: x[LEFT])

    # Map from interval: best score seen so far going to the right
    intv_to_scores = {}
    for i in range(N):
        intv_to_scores[intervals[i]] = scores[i]

    for i in range(N-1, -1, -1):
        for j in range(i+1, N, 1):

            intv_i = intervals[i]
            intv_j = intervals[j]

            if intv_i[RIGHT] <= intv_j[LEFT]:
                intv_to_scores[intv_i] = max(intv_to_scores[intv_i],
                                             scores[i] + intv_to_scores[intv_j])

    return max(intv_to_scores.values())

