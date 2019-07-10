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
        localeUtils.toLocale("b");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_containing_sharp() {
        // given
        // when
        localeUtils.toLocale("#a");
        // then

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_length_is_less_than_three() {
        // given
        // when
        localeUtils.toLocale("_a");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_second_letter_is_lowercase() {
        // given
        // when
        localeUtils.toLocale("_ab");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_third_letter_is_lowercase() {
        // given
        // when
        localeUtils.toLocale("_Ab");
        // then
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
        localeUtils.toLocale("_ABc");
        // then
    }


    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_starting_with_underline_and_fourth_letter_is_not_underline() {
        // given
        // when
        localeUtils.toLocale("_ABctc");
        // then
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
        localeUtils.toLocale("_234");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when__country_is_not_3166() {
        // given
        // when
        localeUtils.toLocale("en_En");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_country_is_empty() {
        // given
        // when
        localeUtils.toLocale("en_");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_language_is_empty() {
        // given
        // when
        localeUtils.toLocale("_12_45");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_has_four_part() {
        // given
        // when
        localeUtils.toLocale("en_123_456_789");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_language_has_four_letter() {
        // given
        // when
        localeUtils.toLocale("engt_ABC");
        // then
    }
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_country_has_three_letter() {
        // given
        // when
        localeUtils.toLocale("eng_ABC");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_country_has_two_nubers() {
        // given
        // when
        localeUtils.toLocale("eng_12");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_languate_is_not_iso639_and_has_three_parts() {
        // given
        // when
        localeUtils.toLocale("engt_123_123");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_country_is_not_right_and_has_three_parts() {
        // given
        // when
        localeUtils.toLocale("eng_a_123");
        // then
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_variant_is_empty_and_has_three_parts() {
        // given
        // when
        localeUtils.toLocale("eng_123_");
        // then
    }




















}