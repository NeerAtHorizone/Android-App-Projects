package com.example.bookreader.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.bookreader.R

data class BookInfo(
    @StringRes val bookName : Int,
    @StringRes val aboutBook: Int,
    @DrawableRes val imgRes: Int,
    @StringRes val bookSummary: Int
)



val BookList = listOf<BookInfo>(
    BookInfo(
        bookName = R.string.book_sapiens,
        aboutBook = R.string.about_book_sapiens,
        imgRes = R.drawable.sapeins_a_brief_history_of_mankind,
        bookSummary = R.string.summary_sapiens
    ),
    BookInfo(
        bookName = R.string.book_nineteeneightyfour,
        aboutBook = R.string.about_book_nineteeneightyfour,
        imgRes = R.drawable.ninetein_atyfour,
        bookSummary = R.string.summary_nineteeneightyfour
    ),
    BookInfo(
        bookName = R.string.book_the_alchemist,
        aboutBook = R.string.about_book_the_alchemist,
        imgRes = R.drawable.the_alchemist,
        bookSummary = R.string.summary_the_alchemist
    ),
    BookInfo(
        bookName = R.string.book_to_kill_a_mockingbird,
        aboutBook = R.string.about_book_to_kill_a_mockingbird,
        imgRes = R.drawable.to_kill_a_mockingbird,
        bookSummary = R.string.summary_to_kill_a_mockingbird
    ),
    BookInfo(
        bookName = R.string.book_the_hobbit,
        aboutBook = R.string.about_book_the_hobbit,
        imgRes = R.drawable.the_hobbit,
        bookSummary = R.string.summary_the_hobbit
    ),
    BookInfo(
        bookName = R.string.book_frankenstein,
        aboutBook = R.string.about_book_frankenstein,
        imgRes = R.drawable.frankestein,
        bookSummary = R.string.summary_frankenstein
    ),
    BookInfo(
        bookName = R.string.book_pride_and_prejudice,
        aboutBook = R.string.about_book_pride_and_prejudice,
        imgRes = R.drawable.pride_and_prejudice,
        bookSummary = R.string.summary_pride_and_prejudice
    ),
    BookInfo(
        bookName = R.string.book_thinking_fast_and_slow,
        aboutBook = R.string.about_book_thinking_fast_and_slow,
        imgRes = R.drawable.thinkin_fast_slow,
        bookSummary = R.string.summary_thinking_fast_and_slow
    ),
    BookInfo(
        bookName = R.string.book_one_hundred_years_of_solitude,
        aboutBook = R.string.about_book_the_psychology_of_money,
        imgRes = R.drawable.onehundred_year_of_soletute,
        bookSummary = R.string.summary_one_hundred_years_of_solitude
    ),
    BookInfo(
        bookName = R.string.book_brave_new_world,
        aboutBook = R.string.about_book_brave_new_world,
        imgRes = R.drawable.brave_new_world,
        bookSummary = R.string.summary_brave_new_world
    ),
    BookInfo(
        bookName = R.string.book_atomic_habits,
        aboutBook = R.string.about_book_atomic_habits,
        imgRes = R.drawable.atomic_habit,
        bookSummary = R.string.summary_atomic_habits
    ),
    BookInfo(
        bookName = R.string.book_the_power_of_now,
        aboutBook = R.string.about_book_the_power_of_now,
        imgRes = R.drawable.power_of_now,
        bookSummary = R.string.summary_the_power_of_now
    ),
    BookInfo(
        bookName = R.string.book_deep_work,
        aboutBook = R.string.about_book_deep_work,
        imgRes = R.drawable.deep_work,
        bookSummary = R.string.summary_deep_work
    ),
    BookInfo(
        bookName = R.string.book_the_subtle_art_of_not_giving_a_f,
        aboutBook = R.string.about_book_the_subtle_art_of_not_giving_a_f,
        imgRes = R.drawable.subtel_art_of_not_giving_af,
        bookSummary = R.string.summary_the_subtle_art_of_not_giving_a_f
    ),
    BookInfo(
        bookName = R.string.book_the_psychology_of_money,
        aboutBook = R.string.about_book_the_psychology_of_money,
        imgRes = R.drawable.the_psycology_of_money,
        bookSummary = R.string.summary_the_psychology_of_money
    ),
    BookInfo(
        bookName = R.string.book_how_to_win_friends_and_influence_people,
        aboutBook = R.string.about_book_how_to_win_friends_and_influence_people,
        imgRes = R.drawable.how_to_win_friends,
        bookSummary = R.string.summary_how_to_win_friends_and_influence_people
    ),
    BookInfo(
        bookName = R.string.book_the_seven_habits_of_highly_effective_people,
        aboutBook = R.string.about_book_the_seven_habits_of_highly_effective_people,
        imgRes = R.drawable.seven_habits_of_highly_effective_people,
        bookSummary = R.string.summary_the_seven_habits_of_highly_effective_people
    ),
    BookInfo(
        bookName = R.string.book_rich_dad_poor_dad,
        aboutBook = R.string.about_book_rich_dad_poor_dad,
        imgRes = R.drawable.rich_dad_poor_dad,
        bookSummary = R.string.summary_rich_dad_poor_dad
    ),
    BookInfo(
        bookName = R.string.book_the_intelligent_investor,
        aboutBook = R.string.about_book_the_intelligent_investor,
        imgRes = R.drawable.the_intelligent_investor,
        bookSummary = R.string.summary_the_intelligent_investor
    ),
    BookInfo(
        bookName = R.string.book_your_money_or_your_life,
        aboutBook = R.string.about_book_your_money_or_your_life,
        imgRes = R.drawable.your_money_or_your_life,
        bookSummary = R.string.summary_your_money_or_your_life
    ),
    BookInfo(
        bookName = R.string.book_i_will_teach_you_to_be_rich,
        aboutBook = R.string.about_book_i_will_teach_you_to_be_rich,
        imgRes = R.drawable.i_will_teach_you_to_be_rich,
        bookSummary = R.string.summary_i_will_teach_you_to_be_rich
    ),
    BookInfo(
        bookName = R.string.book_a_brief_history_of_time,
        aboutBook = R.string.about_book_a_brief_history_of_time,
        imgRes = R.drawable.a_brief_history,
        bookSummary = R.string.summary_a_brief_history_of_time
    ),
    BookInfo(
        bookName = R.string.book_brief_answers_to_the_big_questions,
        aboutBook = R.string.about_book_brief_answers_to_the_big_questions,
        imgRes = R.drawable.brieg_answers_of_big_questions,
        bookSummary = R.string.summary_brief_answers_to_the_big_questions
    ),
    BookInfo(
        bookName = R.string.book_the_code_book,
        aboutBook = R.string.about_book_the_code_book,
        imgRes = R.drawable.the_code_book,
        bookSummary = R.string.summary_the_code_book
    ),
    BookInfo(
        bookName = R.string.book_clean_code,
        aboutBook = R.string.about_book_clean_code,
        imgRes = R.drawable.clean_code,
        bookSummary = R.string.summary_clean_code
    ),
    BookInfo(
        bookName = R.string.book_introduction_to_the_theory_of_computation,
        aboutBook = R.string.book_introduction_to_the_theory_of_computation,
        imgRes = R.drawable.introduction_to_theoryof_computation,
        bookSummary = R.string.summary_introduction_to_the_theory_of_computation
    ),
    BookInfo(
        bookName = R.string.book_ikigai,
        aboutBook = R.string.about_book_ikigai,
        imgRes = R.drawable.ikigai,
        bookSummary = R.string.summary_ikigai
    ),
    BookInfo(
        bookName = R.string.book_mans_search_for_meaning,
        aboutBook = R.string.about_book_mans_search_for_meaning,
        imgRes = R.drawable.mans_search_for_meaning,
        bookSummary = R.string.summary_mans_search_for_meaning
    ),
)