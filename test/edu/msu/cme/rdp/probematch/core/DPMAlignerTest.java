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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jordan Fish <fishjord at msu.edu>
 */
public class DPMAlignerTest {

    public DPMAlignerTest() {
    }

    @Test
    public void testAlign() {
        String textString = "ttaatgggcgtaaagcgcacgc";
        DPMAligner instance = new DPMAligner("AYTGGGYDTAAAGNG", 2);
        DPMAligner.DPMAlignment expResult = new DPMAligner.DPMAlignment("AYTGGGYDTAAAGNG", "aatgggcgtaaagcg" );
        DPMAligner.DPMAlignment result = instance.align(textString);
        assertEquals(expResult.getAlignedMatchFragment(), result.getAlignedMatchFragment());
        assertEquals(expResult.getAlignedProbe(), result.getAlignedProbe() );
        
        // there is one mismatch between the probe and textstring
        instance = new DPMAligner("AYTGGGYDTAAAGNG", 0);
        result = instance.align(textString);
        assertNull(result);
    }
}