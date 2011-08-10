package com.vaadin.tests.server.container.sqlcontainer;

import junit.framework.Assert;

import org.junit.Test;

import com.vaadin.data.util.sqlcontainer.SQLUtil;

public class UtilTest {

    @Test
    public void escapeSQL_noQuotes_returnsSameString() {
        Assert.assertEquals("asdf", SQLUtil.escapeSQL("asdf"));
    }

    @Test
    public void escapeSQL_singleQuotes_returnsEscapedString() {
        Assert.assertEquals("O''Brien", SQLUtil.escapeSQL("O'Brien"));
    }

    @Test
    public void escapeSQL_severalQuotes_returnsEscapedString() {
        Assert.assertEquals("asdf''ghjk''qwerty",
        		SQLUtil.escapeSQL("asdf'ghjk'qwerty"));
    }

    @Test
    public void escapeSQL_doubleQuotes_returnsEscapedString() {
        Assert.assertEquals("asdf\\\"foo", SQLUtil.escapeSQL("asdf\"foo"));
    }

    @Test
    public void escapeSQL_multipleDoubleQuotes_returnsEscapedString() {
        Assert.assertEquals("asdf\\\"foo\\\"bar",
        		SQLUtil.escapeSQL("asdf\"foo\"bar"));
    }

    @Test
    public void escapeSQL_backslashes_returnsEscapedString() {
        Assert.assertEquals("foo\\\\nbar\\\\r", SQLUtil.escapeSQL("foo\\nbar\\r"));
    }

    @Test
    public void escapeSQL_x00_removesX00() {
        Assert.assertEquals("foobar", SQLUtil.escapeSQL("foo\\x00bar"));
    }

    @Test
    public void escapeSQL_x1a_removesX1a() {
        Assert.assertEquals("foobar", SQLUtil.escapeSQL("foo\\x1abar"));
    }
}
