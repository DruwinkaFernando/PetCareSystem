package view;

import java.awt.Color;
import java.awt.Font;

/**
 * Shared color palette and fonts for the whole app.
 * One dark accent (deep purple) for the sidebar/primary buttons,
 * pastel tints for cards and status badges, everything else neutral.
 */
public final class UITheme {

	private UITheme() {}

	// Sidebar / primary
	public static final Color SIDEBAR_BG        = new Color(0x3B, 0x1F, 0x5C);
	public static final Color SIDEBAR_TEXT      = new Color(0xCB, 0xB3, 0xE8);
	public static final Color SIDEBAR_TEXT_ACTIVE = Color.WHITE;
	public static final Color SIDEBAR_ITEM_ACTIVE_BG = new Color(255, 255, 255, 35);

	// Page / surfaces
	public static final Color PAGE_BG   = new Color(0xF7, 0xF5, 0xFB);
	public static final Color CARD_BG   = Color.WHITE;
	public static final Color FORM_BG   = new Color(0xEE, 0xED, 0xFE);

	// Text
	public static final Color TEXT_PRIMARY   = new Color(0x26, 0x21, 0x5C);
	public static final Color TEXT_SECONDARY = new Color(0x5F, 0x5E, 0x5A);

	// Pastel stat / badge colors: {background, text}
	public static final Color PASTEL_PURPLE_BG  = new Color(0xEE, 0xED, 0xFE);
	public static final Color PASTEL_PURPLE_TXT = new Color(0x53, 0x4A, 0xB7);

	public static final Color PASTEL_TEAL_BG  = new Color(0xE1, 0xF5, 0xEE);
	public static final Color PASTEL_TEAL_TXT = new Color(0x0F, 0x6E, 0x56);

	public static final Color PASTEL_CORAL_BG  = new Color(0xFA, 0xEC, 0xE7);
	public static final Color PASTEL_CORAL_TXT = new Color(0x99, 0x3C, 0x1D);

	public static final Color PASTEL_PINK_BG  = new Color(0xFB, 0xEA, 0xF0);
	public static final Color PASTEL_PINK_TXT = new Color(0x99, 0x35, 0x56);

	public static final Color PASTEL_AMBER_BG  = new Color(0xFA, 0xEE, 0xDA);
	public static final Color PASTEL_AMBER_TXT = new Color(0x85, 0x4F, 0x0B);

	// Buttons
	public static final Color BTN_PRIMARY_BG   = SIDEBAR_BG;
	public static final Color BTN_PRIMARY_TXT  = Color.WHITE;
	public static final Color BTN_NEUTRAL_BG   = new Color(0xF1, 0xEF, 0xE8);
	public static final Color BTN_NEUTRAL_TXT  = new Color(0x44, 0x44, 0x41);
	public static final Color BTN_DANGER_BG    = new Color(0xFC, 0xEB, 0xEB);
	public static final Color BTN_DANGER_TXT   = new Color(0x79, 0x1F, 0x1F);

	// Borders
	public static final Color BORDER = new Color(0xE3, 0xE0, 0xEC);

	// Fonts
	public static final Font FONT_TITLE   = new Font("Segoe UI", Font.BOLD, 18);
	public static final Font FONT_SUBTLE  = new Font("Segoe UI", Font.PLAIN, 12);
	public static final Font FONT_LABEL   = new Font("Segoe UI", Font.PLAIN, 13);
	public static final Font FONT_FIELD   = new Font("Segoe UI", Font.PLAIN, 13);
	public static final Font FONT_BUTTON  = new Font("Segoe UI", Font.BOLD, 12);
	public static final Font FONT_NAV     = new Font("Segoe UI", Font.PLAIN, 14);
	public static final Font FONT_NAV_BOLD = new Font("Segoe UI", Font.BOLD, 14);
	public static final Font FONT_TABLE_HEADER = new Font("Segoe UI", Font.BOLD, 12);
	public static final Font FONT_TABLE_CELL   = new Font("Segoe UI", Font.PLAIN, 12);
}
