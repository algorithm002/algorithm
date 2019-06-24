<?php


class Solution {

    public $state = [];

    /**
     * @param Integer[][] $graph
     * @return Integer[]
     */
    function eventualSafeNodes($graph)
    {

        if (!$graph) return [];

        $ret = [];

        for ($i = 0; $i < count($graph); $i ++) {
            if ($this->dfs($graph, $i)) {
                $ret[] = $i;
            }
        }

        return $ret;

    }

    function dfs($graph, $start)
    {
        if (isset($this->state[$start])) return $this->state[$start] == 1;

        $this->state[$start] = 0;
        foreach ($graph[$start] as $next) {
            if (!$this->dfs($graph, $next)) {
                return false;
            }
        }

        $this->state[$start] = 1;
        return true;
    }
}

$graph = [[1,2],[2,3],[5],[0],[5],[],[]];
$sol = new Solution();
var_dump($sol->eventualSafeNodes($graph));