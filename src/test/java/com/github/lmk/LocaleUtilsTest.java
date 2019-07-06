package com.github.lmk;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;


public class LocaleUtilsTest {
    private LocaleUtils localeUtils;
    @Before
    public void setUp() throws Exception {
        localeUtils = new LocaleUtils();
    }

    @Test
    public void should_return_null() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale(null)).isEqualTo(null);
    }

    @Test
    public void should_return_empty() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("")).isEqualToComparingFieldByField(new Locale("",""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_length_is_less_than_2() {
        // given
        // when
        // then
        localeUtils.toLocale("b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_containing_sharp() {
        // given
        // when
        // then
        localeUtils.toLocale("#a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_length_is_less_than_three() {
        // given
        // when
        // then
        localeUtils.toLocale("_a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_second_letter_is_lowercase() {
        // given
        // when
        // then
        localeUtils.toLocale("_ab");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_third_letter_is_lowercase() {
        // given
        // when
        // then
        localeUtils.toLocale("_Ab");
    }

    @Test
    public void should_throw_exception_when_starting_with_underline_and_length_is_three() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("_AB"))
                .isEqualToComparingFieldByField(new Locale("","AB"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_length_is_less_than_five() {
        // given
        // when
        // then
        localeUtils.toLocale("_ABc");
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_fourth_letter_is_not_underline() {
        // given
        // when
        // then
        localeUtils.toLocale("_ABctc");
    }

    @Test
    public void should_throw_exception_when_starting_with_underline_and_is_right() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("_AB_CD"))
                .isEqualToComparingFieldByField(new Locale("","AB","CD"));
    }

    @Test
    public void should_get_locale_when_is_iso639code() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("en"))
                .isEqualToComparingFieldByField(new Locale("en"));
    }

    @Test
    public void should_get_locale_when_language_is_iso639_and_country_is_iso3166() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("eng_UK"))
                .isEqualToComparingFieldByField(new Locale("eng","UK"));
    }

    @Test
    public void should_get_locale_when_language_is_iso639_and_country_is_numeric_area() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("eN_123"))
                .isEqualToComparingFieldByField(new Locale("eN","123"));
    }

    @Test
    public void should_get_locale_when_language_is_iso639_and_no_country_and_has_variant() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("en__234"))
                .isEqualToComparingFieldByField(new Locale("en","","234"));
    }

    @Test
    public void should_get_locale_when_language_is_iso639_and_country_is_numeric_area_and_has_variant() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("en_234_123"))
                .isEqualToComparingFieldByField(new Locale("en","234","123"));
    }

    @Test
    public void should_get_locale_when_language_is_iso639_and_country_is_iso3166_and_has_variant() {
        // given
        // when
        // then
        assertThat(localeUtils.toLocale("en_UK_123"))
                .isEqualToComparingFieldByField(new Locale("en","UK","123"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_language_is_not_iso639() {
        // given
        // when
        // then
        localeUtils.toLocale("_234");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when__country_is_not_3166() {
        // given
        // when
        // then
        localeUtils.toLocale("en_En");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_country_is_empty() {
        // given
        // when
        // then
        localeUtils.toLocale("en_");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_language_is_empty() {
        // given
        // when
        // then
        localeUtils.toLocale("_12_45");
    }



















}