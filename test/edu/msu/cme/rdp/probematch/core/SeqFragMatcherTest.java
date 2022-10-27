/*
 * Copyright (C) 2013 Jordan Fish <fishjord at msu.edu>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.msu.cme.rdp.probematch.core;

import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan Fish <fishjord at msu.edu>
 */
public class SeqFragMatcherTest {

    public SeqFragMatcherTest() {
    }

    @Test
    public void testGetBestMatch() {
        String patt =    "ACAGTC";
        String query = "XXXACTGTXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

        SeqFragMatcher matcher = new SeqFragMatcher(patt, Integer.MAX_VALUE, false);
        System.out.println("getBestMatch");
        FragmentMatch result = matcher.getBestMatch(query);
        assertEquals(3, result.getStart());
        assertEquals(9, result.getEnd());
        assertEquals(2, result.getScore());
        assertEquals("ACAGTC", result.getAlignedMatchRegion());
        assertEquals("ACTGTX", result.getAlignedFragment());
    }

    @Test
    public void testGetMatches() {
        System.out.println("getMatches");
        String sequence = "ttaatgggcgtaaagcgcacgc";
        SeqFragMatcher instance = new SeqFragMatcher("AYTGGGYDTAAAGNG", 2, true);
        Set<FragmentMatch> result = instance.getMatches(sequence);
        FragmentMatch firstResult = (FragmentMatch)(result.toArray())[0];
        
        assertEquals("aatgggcgtaaagcg", firstResult.getAlignedFragment());
        assertEquals("AYTGGGYDTAAAGNG", firstResult.getAlignedMatchRegion());
    }
}