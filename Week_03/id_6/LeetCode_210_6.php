<?php


class Solution {

    /**
     * @param Integer $numCourses
     * @param Integer[][] $prerequisites
     * @return Integer[]
     */
    function findOrder($numCourses, $prerequisites)
    {
        if ($numCourses <= 0) return [];

        $in_degree = [];
        $graph = [];
        $queue = [];

        foreach ($prerequisites as $prerequisite) {
            $graph[$prerequisite[1]][] = $prerequisite[0];
            if (!isset($in_degree[$prerequisite[0]])) $in_degree[$prerequisite[0]] = 0;
            $in_degree[$prerequisite[0]] ++;
        }

        for ($i = 0; $i < $numCourses; $i ++) {
            if (!isset($in_degree[$i])) {
                $queue[] = $i;
            }
        }

        $res = [];
        while ($queue) {
            $node = array_shift($queue);
            $res[] =  $node;
            if (!isset($graph[$node])) {
                continue;
            }
            $next_courses = $graph[$node];
            foreach ($next_courses as $next_course) {
                $in_degree[$next_course] --;
                if ($in_degree[$next_course] == 0) {
                    $queue[] = $next_course;
                }
            }
        }

        if (count($res) == $numCourses) {
            return $res;
        }

        return [];
    }
}

$sol = new Solution();
$numCourses = 4;
$prerequisites = [[1,0],[2,0],[3,1],[3,2]];
var_export($sol->findOrder($numCourses, $prerequisites));